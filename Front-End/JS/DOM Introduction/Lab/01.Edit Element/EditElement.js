function editElement(ref, match, replacer) {
    let name = ref.textContent
    let editedText = name.replace(new RegExp(match, 'g'), replacer)
    ref.textContent = editedText
}