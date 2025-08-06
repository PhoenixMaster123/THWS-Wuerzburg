document.addEventListener('DOMContentLoaded', () => {
    const activityForm = document.getElementById('activity-form');
    const foodForm = document.getElementById('food-form');
    const activityList = document.getElementById('activity-list');
    const foodList = document.getElementById('food-list');
    const clearAllActivitiesBtn = document.getElementById('clear-all-activities-btn');
    const clearAllFoodBtn = document.getElementById('clear-all-food-btn');
    const filterActivityType = document.getElementById('filter-activity-type');
    const filterFoodDate = document.getElementById('filter-food-date');
    const alertMessage = document.getElementById('alert-message');

    // Summary Elements
    const caloriesConsumedSpan = document.getElementById('calories-consumed');
    const caloriesBurnedSpan = document.getElementById('calories-burned');
    const netCaloriesSpan = document.getElementById('net-calories');
    const totalDistanceSpan = document.getElementById('total-distance');
    const totalActivityDurationSpan = document.getElementById('total-activity-duration');
    const totalActivitiesCountSpan = document.getElementById('total-activities-count');

    // Daily Plan Elements
    const planDateInput = document.getElementById('plan-date');
    const workoutSelector = document.getElementById('workout-selector');
    const generatePlanBtn = document.getElementById('generate-plan-btn');
    const planDisplayDate = document.getElementById('plan-display-date');
    const dailyWorkoutDiv = document.getElementById('daily-workout');
    const breakfastSuggestionsUl = document.getElementById('breakfast-suggestions');
    const lunchSuggestionsUl = document.getElementById('lunch-suggestions');
    const dinnerSuggestionsUl = document.getElementById('dinner-suggestions');
    const snackSuggestionsUl = document.getElementById('snack-suggestions');

    let activities = JSON.parse(localStorage.getItem('activities')) || [];
    let foodItems = JSON.parse(localStorage.getItem('foodItems')) || [];
    let dailyPlans = JSON.parse(localStorage.getItem('dailyPlans')) || {}; // Stores plans by date

    const today = new Date();
    today.setHours(0, 0, 0, 0);
    const todayISO = today.toISOString().split('T')[0];

    // Set default dates
    activityForm.elements['activity-date'].value = todayISO;
    foodForm.elements['food-date'].value = todayISO;
    planDateInput.value = todayISO;
    filterFoodDate.value = todayISO;

    // --- Helper Functions ---

    function showAlert(message, type, duration = 3000) {
        alertMessage.textContent = message;
        alertMessage.className = `alert-message show ${type}`;
        setTimeout(() => {
            alertMessage.classList.remove('show');
        }, duration);
    }

    function calculateCaloriesBurned(type, duration, distance) {
        let caloriesPerMinute = 0;
        let caloriesPerKm = 0;

        switch (type) {
            case 'running':
                caloriesPerMinute = 10; // avg for moderate running
                caloriesPerKm = 60; // additional per km
                break;
            case 'walking':
                caloriesPerMinute = 4; // avg for brisk walking
                caloriesPerKm = 30;
                break;
            case 'cycling':
                caloriesPerMinute = 7; // avg for moderate cycling
                caloriesPerKm = 25;
                break;
            case 'hiking':
                caloriesPerMinute = 6;
                caloriesPerKm = 40;
                break;
            case 'swimming':
                caloriesPerMinute = 8;
                break;
            case 'yoga':
                caloriesPerMinute = 3;
                break;
            case 'strength-training':
                caloriesPerMinute = 7;
                break;
            case 'other':
                caloriesPerMinute = 5; // default for other
                break;
        }

        let totalCalories = caloriesPerMinute * duration;
        if (distance) {
            totalCalories += caloriesPerKm * distance;
        }
        return Math.round(totalCalories);
    }

    function getActivityIcon(type) {
        switch (type) {
            case 'running': return '<i class="fas fa-running icon-running"></i>';
            case 'walking': return '<i class="fas fa-walking icon-walking"></i>';
            case 'cycling': return '<i class="fas fa-cycling icon-cycling"></i>'; // Font Awesome 6
            case 'hiking': return '<i class="fas fa-mountain icon-hiking"></i>';
            case 'swimming': return '<i class="fas fa-swimmer icon-swimming"></i>';
            case 'yoga': return '<i class="fas fa-om icon-yoga"></i>';
            case 'strength-training': return '<i class="fas fa-dumbbell icon-strength-training"></i>';
            case 'other': return '<i class="fas fa-heartbeat icon-other"></i>';
            default: return '<i class="fas fa-question-circle"></i>';
        }
    }

    function getFoodIcon() {
        return '<i class="fas fa-utensils icon-food"></i>';
    }


    // --- Render Functions ---

    function renderActivities(filterType = 'all') {
        activityList.innerHTML = '';
        const filteredActivities = activities.filter(activity =>
            filterType === 'all' || activity.type === filterType
        ).sort((a, b) => new Date(b.date) - new Date(a.date)); // Sort by date, newest first

        if (filteredActivities.length === 0) {
            activityList.innerHTML = '<li class="no-entries-message">No activities logged yet. Start tracking!</li>';
            return;
        }

        filteredActivities.forEach(activity => {
            const li = document.createElement('li');
            li.setAttribute('data-id', activity.id);
            li.classList.add('activity-item-new'); // For animation

            const icon = getActivityIcon(activity.type);
            const date = new Date(activity.date).toLocaleDateString('en-US', { year: 'numeric', month: 'short', day: 'numeric' });

            li.innerHTML = `
                <div class="details">
                    <strong>${icon} ${activity.type.charAt(0).toUpperCase() + activity.type.slice(1)}</strong>
                    <p>Distance: <span class="editable" data-field="distance">${activity.distance}</span> km</p>
                    <p>Duration: <span class="editable" data-field="duration">${activity.duration}</span> mins</p>
                    <p>Calories Burned: <span>${activity.caloriesBurned}</span> kcal</p>
                    <p>Date: <span>${date}</span></p>
                    <p>Notes: <span class="editable" data-field="notes">${activity.notes || 'N/A'}</span></p>
                </div>
                <div class="actions">
                    <button class="btn info-btn btn-edit-activity">Edit</button>
                    <button class="btn danger-btn btn-delete-activity">Delete</button>
                </div>
            `;
            activityList.appendChild(li);
        });
        updateSummary();
    }

    function renderFoodItems(filterDate = todayISO) {
        foodList.innerHTML = '';
        const filteredFood = foodItems.filter(item => item.date === filterDate)
            .sort((a, b) => new Date(b.date) - new Date(a.date)); // Sort by date, newest first

        if (filteredFood.length === 0) {
            foodList.innerHTML = '<li class="no-entries-message">No food items logged for this date.</li>';
            return;
        }

        filteredFood.forEach(item => {
            const li = document.createElement('li');
            li.setAttribute('data-id', item.id);
            li.classList.add('food-item-new'); // For animation

            const icon = getFoodIcon();
            const date = new Date(item.date).toLocaleDateString('en-US', { year: 'numeric', month: 'short', day: 'numeric' });
            const totalCalories = item.calories * item.servings;

            li.innerHTML = `
                <div class="details">
                    <strong>${icon} ${item.name}</strong>
                    <p>Calories per serving: <span class="editable" data-field="calories">${item.calories}</span> kcal</p>
                    <p>Servings: <span class="editable" data-field="servings">${item.servings}</span></p>
                    <p>Total Calories: <span>${totalCalories}</span> kcal</p>
                    <p>Date: <span>${date}</span></p>
                </div>
                <div class="actions">
                    <button class="btn info-btn btn-edit-food">Edit</button>
                    <button class="btn danger-btn btn-delete-food">Delete</button>
                </div>
            `;
            foodList.appendChild(li);
        });
        updateSummary();
    }

    function updateSummary() {
        const todayActivities = activities.filter(a => a.date === todayISO);
        const todayFoodItems = foodItems.filter(f => f.date === todayISO);

        const totalCaloriesConsumed = todayFoodItems.reduce((sum, item) => sum + (item.calories * item.servings), 0);
        const totalCaloriesBurned = todayActivities.reduce((sum, activity) => sum + activity.caloriesBurned, 0);
        const totalDistance = todayActivities.reduce((sum, activity) => sum + activity.distance, 0);
        const totalActivityDuration = todayActivities.reduce((sum, activity) => sum + activity.duration, 0);

        caloriesConsumedSpan.textContent = totalCaloriesConsumed;
        caloriesBurnedSpan.textContent = totalCaloriesBurned;
        netCaloriesSpan.textContent = totalCaloriesConsumed - totalCaloriesBurned;
        totalDistanceSpan.textContent = totalDistance.toFixed(1);
        totalActivityDurationSpan.textContent = totalActivityDuration;
        totalActivitiesCountSpan.textContent = todayActivities.length;
    }

    // --- Activity Log Functionality ---

    activityForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const type = document.getElementById('activity-type').value;
        const distance = parseFloat(document.getElementById('distance').value);
        const duration = parseInt(document.getElementById('duration').value);
        const date = document.getElementById('activity-date').value;
        const notes = document.getElementById('activity-notes').value;

        if (isNaN(distance) || isNaN(duration)) {
            showAlert('Please enter valid numbers for distance and duration.', 'error');
            return;
        }

        const caloriesBurned = calculateCaloriesBurned(type, duration, distance);
        const newActivity = {
            id: Date.now(),
            type,
            distance,
            duration,
            caloriesBurned,
            date,
            notes
        };

        activities.push(newActivity);
        localStorage.setItem('activities', JSON.stringify(activities));
        renderActivities(filterActivityType.value);
        showAlert('Activity added successfully!', 'success');
        activityForm.reset();
        activityForm.elements['activity-date'].value = todayISO; // Reset date to today
    });

    activityList.addEventListener('click', (e) => {
        const activityItem = e.target.closest('li');
        if (!activityItem) return;

        const activityId = parseInt(activityItem.dataset.id);
        const activityIndex = activities.findIndex(a => a.id === activityId);

        if (e.target.classList.contains('btn-delete-activity')) {
            if (confirm('Are you sure you want to delete this activity?')) {
                activities.splice(activityIndex, 1);
                localStorage.setItem('activities', JSON.stringify(activities));
                renderActivities(filterActivityType.value);
                showAlert('Activity deleted.', 'info');
            }
        } else if (e.target.classList.contains('btn-edit-activity')) {
            activityItem.classList.add('editing');
            const details = activityItem.querySelector('.details');
            const currentActivity = activities[activityIndex];

            // Replace text with input fields for editable fields
            details.querySelectorAll('.editable').forEach(span => {
                const field = span.dataset.field;
                let input;
                if (field === 'notes') {
                    input = document.createElement('textarea');
                    input.value = currentActivity[field] || '';
                    input.rows = 2;
                } else {
                    input = document.createElement('input');
                    input.type = 'number';
                    input.step = '0.1';
                    input.value = currentActivity[field];
                }
                input.classList.add('edit-input');
                span.replaceWith(input);
            });

            // Change buttons
            e.target.textContent = 'Save';
            e.target.classList.remove('info-btn');
            e.target.classList.add('primary-btn', 'btn-save-activity');
            e.target.nextElementSibling.textContent = 'Cancel';
            e.target.nextElementSibling.classList.remove('danger-btn');
            e.target.nextElementSibling.classList.add('warning-btn', 'btn-cancel-edit');
        } else if (e.target.classList.contains('btn-save-activity')) {
            const inputs = activityItem.querySelectorAll('.edit-input');
            const updatedActivity = { ...activities[activityIndex] };

            inputs.forEach(input => {
                const field = input.previousElementSibling.dataset.field || input.dataset.field; // Get original data-field if available
                if (field === 'distance' || field === 'duration') {
                    updatedActivity[field] = parseFloat(input.value);
                } else if (field === 'notes') {
                    updatedActivity[field] = input.value;
                }
            });

            // Recalculate calories burned if duration/distance changed
            updatedActivity.caloriesBurned = calculateCaloriesBurned(updatedActivity.type, updatedActivity.duration, updatedActivity.distance);

            activities[activityIndex] = updatedActivity;
            localStorage.setItem('activities', JSON.stringify(activities));
            activityItem.classList.remove('editing');
            renderActivities(filterActivityType.value);
            showAlert('Activity updated successfully!', 'success');
        } else if (e.target.classList.contains('btn-cancel-edit')) {
            activityItem.classList.remove('editing');
            renderActivities(filterActivityType.value); // Re-render to revert changes
            showAlert('Edit cancelled.', 'info');
        }
    });

    clearAllActivitiesBtn.addEventListener('click', () => {
        if (confirm('Are you sure you want to clear all activities? This cannot be undone.')) {
            activities = [];
            localStorage.setItem('activities', JSON.stringify(activities));
            renderActivities();
            showAlert('All activities cleared.', 'info');
        }
    });

    filterActivityType.addEventListener('change', (e) => {
        renderActivities(e.target.value);
    });

    // --- Food Log Functionality ---

    foodForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const name = document.getElementById('food-item').value;
        const calories = parseInt(document.getElementById('food-calories').value);
        const servings = parseFloat(document.getElementById('food-servings').value);
        const date = document.getElementById('food-date').value;

        if (isNaN(calories) || isNaN(servings) || servings <= 0) {
            showAlert('Please enter valid numbers for calories and servings.', 'error');
            return;
        }

        const newFoodItem = {
            id: Date.now(),
            name,
            calories,
            servings,
            date
        };

        foodItems.push(newFoodItem);
        localStorage.setItem('foodItems', JSON.stringify(foodItems));
        renderFoodItems(filterFoodDate.value);
        showAlert('Food item added successfully!', 'success');
        foodForm.reset();
        foodForm.elements['food-date'].value = todayISO; // Reset date to today
    });

    foodList.addEventListener('click', (e) => {
        const foodItem = e.target.closest('li');
        if (!foodItem) return;

        const foodId = parseInt(foodItem.dataset.id);
        const foodIndex = foodItems.findIndex(f => f.id === foodId);

        if (e.target.classList.contains('btn-delete-food')) {
            if (confirm('Are you sure you want to delete this food item?')) {
                foodItems.splice(foodIndex, 1);
                localStorage.setItem('foodItems', JSON.stringify(foodItems));
                renderFoodItems(filterFoodDate.value);
                showAlert('Food item deleted.', 'info');
            }
        } else if (e.target.classList.contains('btn-edit-food')) {
            foodItem.classList.add('editing');
            const details = foodItem.querySelector('.details');
            const currentFood = foodItems[foodIndex];

            // Replace text with input fields for editable fields
            details.querySelectorAll('.editable').forEach(span => {
                const field = span.dataset.field;
                const input = document.createElement('input');
                input.type = 'number';
                input.step = '0.1';
                input.value = currentFood[field];
                input.classList.add('edit-input');
                span.replaceWith(input);
            });

            // Change buttons
            e.target.textContent = 'Save';
            e.target.classList.remove('info-btn');
            e.target.classList.add('primary-btn', 'btn-save-food');
            e.target.nextElementSibling.textContent = 'Cancel';
            e.target.nextElementSibling.classList.remove('danger-btn');
            e.target.nextElementSibling.classList.add('warning-btn', 'btn-cancel-edit');
        } else if (e.target.classList.contains('btn-save-food')) {
            const inputs = foodItem.querySelectorAll('.edit-input');
            const updatedFood = { ...foodItems[foodIndex] };

            inputs.forEach(input => {
                const field = input.previousElementSibling.dataset.field || input.dataset.field;
                updatedFood[field] = parseFloat(input.value);
            });

            foodItems[foodIndex] = updatedFood;
            localStorage.setItem('foodItems', JSON.stringify(foodItems));
            foodItem.classList.remove('editing');
            renderFoodItems(filterFoodDate.value);
            showAlert('Food item updated successfully!', 'success');
        } else if (e.target.classList.contains('btn-cancel-edit')) {
            foodItem.classList.remove('editing');
            renderFoodItems(filterFoodDate.value); // Re-render to revert changes
            showAlert('Edit cancelled.', 'info');
        }
    });

    clearAllFoodBtn.addEventListener('click', () => {
        if (confirm('Are you sure you want to clear all food items? This cannot be undone.')) {
            foodItems = [];
            localStorage.setItem('foodItems', JSON.stringify(foodItems));
            renderFoodItems();
            showAlert('All food items cleared.', 'info');
        }
    });

    filterFoodDate.addEventListener('change', (e) => {
        renderFoodItems(e.target.value);
    });

    // --- Daily Plan Functionality ---

    const workoutPlans = {
        'Monday': {
            name: 'Full Body Strength',
            exercises: [
                'Squats: 3 sets of 8-12 reps',
                'Push-ups: 3 sets to failure',
                'Dumbbell Rows: 3 sets of 8-12 reps per arm',
                'Overhead Press: 3 sets of 8-12 reps',
                'Plank: 3 sets, hold for 30-60 seconds'
            ]
        },
        'Tuesday': {
            name: 'Cardio & Core',
            exercises: [
                '30-45 minutes moderate cardio (e.g., jogging, cycling)',
                'Crunches: 3 sets of 15-20 reps',
                'Leg Raises: 3 sets of 15-20 reps',
                'Russian Twists: 3 sets of 15-20 reps per side'
            ]
        },
        'Wednesday': {
            name: 'Upper Body & Abs',
            exercises: [
                'Bench Press (Dumbbell or Barbell): 3 sets of 8-12 reps',
                'Lat Pulldowns / Pull-ups: 3 sets of 8-12 reps',
                'Bicep Curls: 3 sets of 10-15 reps',
                'Tricep Extensions: 3 sets of 10-15 reps',
                'Side Plank: 3 sets, hold 30-60 seconds per side'
            ]
        },
        'Thursday': {
            name: 'Rest or Active Recovery',
            exercises: [
                'Light stretching or yoga',
                '20-30 minutes brisk walking or easy cycling',
                'Foam Rolling'
            ]
        },
        'Friday': {
            name: 'Lower Body & Glutes',
            exercises: [
                'Deadlifts (Romanian or Conventional): 3 sets of 6-10 reps',
                'Lunges: 3 sets of 10-12 reps per leg',
                'Glute Bridges: 3 sets of 12-15 reps',
                'Calf Raises: 3 sets of 15-20 reps',
                'Leg Press (if available): 3 sets of 10-15 reps'
            ]
        },
        'Saturday': {
            name: 'Cardio & Full Body Circuit',
            exercises: [
                '20 minutes HIIT (e.g., burpees, jump squats, mountain climbers)',
                'Circuit: 3 rounds of (10-15 reps each): Kettlebell Swings, Wall Balls, Box Jumps',
                'Cool-down stretch'
            ]
        },
        'Sunday': {
            name: 'Rest or Active Recovery',
            exercises: [
                'Leisurely walk or gentle cycling',
                'Meditation',
                'Focus on hydration and nutrition'
            ]
        }
    };

    const mealPlans = {
        'general': { // General healthy meals, can be adapted
            'breakfast': [
                'Oatmeal with berries and nuts (350 kcal)',
                'Scrambled eggs (2) with spinach and whole-wheat toast (380 kcal)',
                'Greek yogurt with granola and fruit (320 kcal)',
                'Protein smoothie (protein powder, banana, spinach, almond milk) (300 kcal)'
            ],
            'lunch': [
                'Grilled chicken salad with mixed greens, avocado, and vinaigrette (550 kcal)',
                'Quinoa bowl with roasted vegetables and chickpeas (600 kcal)',
                'Whole-wheat turkey wrap with hummus and veggies (580 kcal)',
                'Lentil soup with a side of whole-grain bread (520 kcal)'
            ],
            'dinner': [
                'Baked salmon with sweet potato and steamed broccoli (650 kcal)',
                'Lean ground beef stir-fry with brown rice and mixed vegetables (680 kcal)',
                'Chicken breast with quinoa and asparagus (620 kcal)',
                'Vegetable curry with basmati rice (590 kcal)'
            ],
            'snacks': [
                'Apple slices with peanut butter (180 kcal)',
                'Handful of almonds (170 kcal)',
                'Hard-boiled egg (70 kcal)',
                'Rice cakes with avocado (150 kcal)',
                'Small fruit (e.g., orange, banana) (90-120 kcal)'
            ]
        },
        // You could add specific plans for certain days or types of diets here
        'Monday_breakfast': ['Protein Pancakes with fruit (400 kcal)'],
        'Friday_dinner': ['Homemade veggie pizza (600 kcal)']
    };


    function renderDailyPlan(dateStr, selectedWorkoutKey = 'default') {
        planDisplayDate.textContent = new Date(dateStr).toLocaleDateString('en-US', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' });

        const dayOfWeek = new Date(dateStr).toLocaleDateString('en-US', { weekday: 'long' });

        let plan = dailyPlans[dateStr];

        if (!plan) {
            // Generate a new plan if one doesn't exist for this date
            const workoutPlan = selectedWorkoutKey !== 'default' && workoutPlans[selectedWorkoutKey] ?
                                workoutPlans[selectedWorkoutKey] :
                                workoutPlans[dayOfWeek];

            plan = {
                workout: workoutPlan || { name: 'No Scheduled Workout', exercises: ['Enjoy your day!'] },
                meals: {
                    breakfast: mealPlans[`${dayOfWeek}_breakfast`] || getRandomMeal(mealPlans.general.breakfast, 2),
                    lunch: mealPlans[`${dayOfWeek}_lunch`] || getRandomMeal(mealPlans.general.lunch, 2),
                    dinner: mealPlans[`${dayOfWeek}_dinner`] || getRandomMeal(mealPlans.general.dinner, 2),
                    snacks: getRandomMeal(mealPlans.general.snacks, 3)
                }
            };
            dailyPlans[dateStr] = plan;
            localStorage.setItem('dailyPlans', JSON.stringify(dailyPlans));
        } else if (selectedWorkoutKey !== 'default') {
            // If a plan exists but a specific workout is selected, update only the workout
            plan.workout = workoutPlans[selectedWorkoutKey] || { name: 'No Scheduled Workout', exercises: ['Enjoy your day!'] };
            dailyPlans[dateStr] = plan;
            localStorage.setItem('dailyPlans', JSON.stringify(dailyPlans));
        }

        // Render Workout
        dailyWorkoutDiv.innerHTML = `<h4>${plan.workout.name}</h4>`;
        const workoutUl = document.createElement('ul');
        if (plan.workout.exercises && plan.workout.exercises.length > 0) {
            plan.workout.exercises.forEach(exercise => {
                const li = document.createElement('li');
                li.textContent = exercise;
                workoutUl.appendChild(li);
            });
        } else {
            const li = document.createElement('li');
            li.textContent = 'No workout details available.';
            workoutUl.appendChild(li);
        }
        dailyWorkoutDiv.appendChild(workoutUl);

        // Render Meals
        renderMealCategory(breakfastSuggestionsUl, plan.meals.breakfast, 'No breakfast suggestions for this day.');
        renderMealCategory(lunchSuggestionsUl, plan.meals.lunch, 'No lunch suggestions for this day.');
        renderMealCategory(dinnerSuggestionsUl, plan.meals.dinner, 'No dinner suggestions for this day.');
        renderMealCategory(snackSuggestionsUl, plan.meals.snacks, 'No snack suggestions for this day.');
    }

    function getRandomMeal(mealArray, count) {
        if (!mealArray || mealArray.length === 0) return [];
        const shuffled = [...mealArray].sort(() => 0.5 - Math.random());
        return shuffled.slice(0, count);
    }

    function renderMealCategory(ulElement, suggestions, noMessage) {
        ulElement.innerHTML = '';
        if (suggestions && suggestions.length > 0) {
            suggestions.forEach(item => {
                const li = document.createElement('li');
                li.innerHTML = `<i class="fas fa-dot-circle meal-bullet"></i> ${item}`; // Add a small icon
                ulElement.appendChild(li);
            });
        } else {
            const li = document.createElement('li');
            li.classList.add('no-plan-message');
            li.textContent = noMessage;
            ulElement.appendChild(li);
        }
    }

    // --- Event Listeners for Daily Plan ---

    planDateInput.addEventListener('change', (e) => {
        const selectedDate = e.target.value;
        workoutSelector.value = 'default'; // Reset workout selector when date changes
        renderDailyPlan(selectedDate);
    });

    workoutSelector.addEventListener('change', (e) => {
        const selectedDate = planDateInput.value;
        const selectedWorkout = e.target.value;
        renderDailyPlan(selectedDate, selectedWorkout); // Re-render plan with selected workout
    });

    generatePlanBtn.addEventListener('click', () => {
        const selectedDate = planDateInput.value;
        // Force re-generation by deleting existing plan for the date
        delete dailyPlans[selectedDate];
        localStorage.setItem('dailyPlans', JSON.stringify(dailyPlans));
        renderDailyPlan(selectedDate, workoutSelector.value);
        showAlert('New plan generated for the selected date!', 'success');
    });

    // --- Initial Renders ---
    renderActivities();
    renderFoodItems(todayISO);
    renderDailyPlan(todayISO); // Render daily plan for today on load

    // Add Font Awesome Kit Script dynamically
    const fontAwesomeScript = document.createElement('script');
    fontAwesomeScript.src = 'https://kit.fontawesome.com/YOUR_FONT_AWESOME_KIT_CODE.js'; // Replace with your actual Font Awesome Kit code
    fontAwesomeScript.crossOrigin = 'anonymous';
    document.head.appendChild(fontAwesomeScript);
});