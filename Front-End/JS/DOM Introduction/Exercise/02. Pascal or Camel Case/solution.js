function solve() {
  let text = document.getElementById('text').value.split(' ');
  let namingConvention = document.getElementById('naming-convention').value;
  let result = [];

  if (namingConvention === 'Camel Case') {
    result.push(text[0].toLowerCase());
  } else if (namingConvention === 'Pascal Case') {
    let firstLetter = text[0].charAt(0).toUpperCase();
    let remainingLetters = text[0].slice(1).toLowerCase();
    result.push(firstLetter + remainingLetters)
  } else {
    document.getElementById('result').innerText = 'Error!'
    return
  }

  for (let i = 1; i < text.length; i++) {
    let firstLetter = text[i].charAt(0).toUpperCase();
    let remainingLetters = text[i].slice(1).toLowerCase();
    result.push(firstLetter + remainingLetters)
  }

  document.getElementById('result').innerText = result.join('');
}