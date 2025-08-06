function solve() {
    h1 = document.getElementById('head');
    temp = h1.textContent;
    btn = document.getElementById('btn');
    btn.addEventListener('click', onClick);
    document.getElementById('btn-reverse').addEventListener('click', () =>{
        h1.textContent = temp

    })
    function onClick() {
        h1.textContent = 'Header is changed';
    }
}

solve()
