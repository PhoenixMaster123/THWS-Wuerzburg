function calculate() {
    const num1 = parseFloat(document.getElementById('num1').value);
    const num2 = parseFloat(document.getElementById('num2').value);
    const op = document.getElementById('op').value;
    let result = 0;
    switch (op) {
        case '+':
            result = num1 + num2
            break;
        case '-': 
        result = num1 - num2
            break;
        case '*':
            result = num1 * num2
            break;
        case '/':
            result = num1 / num2
            break;               
        default:
            result = undefined;
            break;
    }

    document.getElementById('result').value = isNaN(result) ? 'Invalid input' : result;
}