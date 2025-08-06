let div = document.createElement('div');

div.style = 'width: 250px; background: black; height: 100px;';
document.body.appendChild(div);

div.addEventListener('mouseover', () => {
  div.style.background = 'green';
});

div.addEventListener('mouseout', () => {
  div.style.background = 'black';
});