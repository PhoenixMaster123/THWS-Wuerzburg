package _06_Evolutionary_Algorithmen;

import java.util.*;

public class GeneticAlgorithmTSP {
    private static final int[][] distanceMatrix = {
            {0, 10, 3, 5, 9, 8},  // A
            {1, 0, 7, 2, 8, 6},   // B
            {5, 1, 0, 3, 7, 5},   // C
            {6, 3, 2, 0, 1, 7},   // D
            {6, 4, 3, 1, 0, 9},   // E
            {5, 3, 7, 4, 1, 0}    // F
    };

    private static final int POPULATION_SIZE = 100;
    private static final int GENERATIONS = 500;
    private static final double MUTATION_RATE = 0.1;

    public static void main(String[] args) {
        List<List<Integer>> population = initializePopulation();

        for (int generation = 0; generation < GENERATIONS; generation++) {
            // 1. Fitness-Bewertung
            population.sort(Comparator.comparingInt(GeneticAlgorithmTSP::calculateRouteDistance));

            // Beste Lösung dieser Generation
            int bestDistance = calculateRouteDistance(population.get(0));
            System.out.println("Generation " + generation + ": Beste Distanz = " + bestDistance);

            // 2. Selektion
            List<List<Integer>> selected = selectBestIndividuals(population);

            // 3. Crossover
            List<List<Integer>> offspring = crossover(selected);

            // 4. Mutation
            mutatePopulation(offspring);

            // 5. Neue Population
            population = offspring;
        }

        // Beste Lösung nach allen Generationen
        List<Integer> bestRoute = population.get(0);
        System.out.println("Beste Route: " + bestRoute);
        System.out.println("Distanz: " + calculateRouteDistance(bestRoute));
    }

    private static List<List<Integer>> initializePopulation() {
        List<List<Integer>> population = new ArrayList<>();
        List<Integer> nodes = Arrays.asList(0, 1, 2, 3, 4, 5);

        for (int i = 0; i < POPULATION_SIZE; i++) {
            List<Integer> individual = new ArrayList<>(nodes);
            Collections.shuffle(individual);
            individual.add(0); // Zurück zu A
            population.add(individual);
        }
        return population;
    }

    private static int calculateRouteDistance(List<Integer> route) {
        int distance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            int from = route.get(i);
            int to = route.get(i + 1);
            distance += distanceMatrix[from][to];
        }
        return distance;
    }

    private static List<List<Integer>> selectBestIndividuals(List<List<Integer>> population) {
        // Nimm die besten 50% der Population
        return population.subList(0, population.size() / 2);
    }

    private static List<List<Integer>> crossover(List<List<Integer>> selected) {
        List<List<Integer>> offspring = new ArrayList<>();
        Random random = new Random();

        while (offspring.size() < POPULATION_SIZE) {
            List<Integer> parent1 = selected.get(random.nextInt(selected.size()));
            List<Integer> parent2 = selected.get(random.nextInt(selected.size()));

            // PMX-Crossover oder ein einfacher Ansatz
            List<Integer> child = crossoverParents(parent1, parent2);
            offspring.add(child);
        }

        return offspring;
    }

    private static List<Integer> crossoverParents(List<Integer> parent1, List<Integer> parent2) {
        Random random = new Random();
        int size = parent1.size() - 1;

        int start = random.nextInt(size);
        int end = random.nextInt(size - start) + start;

        List<Integer> child = new ArrayList<>(Collections.nCopies(size, -1));

        // Kopiere Segment von Parent1
        for (int i = start; i < end; i++) {
            child.set(i, parent1.get(i));
        }

        // Fülle mit Parent2 (ohne Duplikate)
        for (int i = 0; i < size; i++) {
            if (!child.contains(parent2.get(i))) {
                for (int j = 0; j < size; j++) {
                    if (child.get(j) == -1) {
                        child.set(j, parent2.get(i));
                        break;
                    }
                }
            }
        }
        child.add(0); // Zurück zu A
        return child;
    }

    private static void mutatePopulation(List<List<Integer>> population) {
        Random random = new Random();
        for (List<Integer> individual : population) {
            if (random.nextDouble() < MUTATION_RATE) {
                int index1 = random.nextInt(individual.size() - 1);
                int index2 = random.nextInt(individual.size() - 1);

                // Vertausche zwei Knoten
                Collections.swap(individual, index1, index2);
            }
        }
    }
}
