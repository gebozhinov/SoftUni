function search() {
   let towns = Array.from(document.querySelectorAll('li'));
   let search = document.getElementById('searchText').value;
   let matches = 0;
   towns.style = "";

   for (const li of towns) {
      if (li.textContent.includes(search)) {
         li.style.fontWeight = 'bold';
         li.style.textDecoration = 'underline';
         matches++;
      }
   }

   document.getElementById('result').innerText = `${matches} matches found`
}
