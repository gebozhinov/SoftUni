function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   let search = document.getElementById('searchField');
   let rows = document.querySelectorAll('tbody tr');

   function onClick() {
      for (const row of rows) {
         row.classList.remove('select')
         if (search !== '' && row.innerHTML.includes(search.value)) {
            row.className = 'select'
         }
      }
   }

   search.value = '';
}