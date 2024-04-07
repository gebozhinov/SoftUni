function solve() {
  let inputText = document.getElementById('input').value;
  let outputText = document.getElementById('output');

  let sentence = inputText.split('.');

  sentence = sentence
  .filter(s => s.length > 0)
  .map(s => s += '.');
  
  while (sentence.length > 0) {
    let p = document.createElement('p');
    p.textContent = sentence.splice(0, 3).join('');
    outputText.appendChild(p);
  }
}