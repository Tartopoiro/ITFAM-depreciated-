
// Initialisation après chargement du DOM
document.addEventListener("DOMContentLoaded", function() {
    const monBouton = document.getElementById('confirm');

    monBouton.addEventListener('click', function(event) {
        if (confirm("Veuillez confirmer")) {
            window.location.href = this.getAttribute('href');
        } else {
            event.preventDefault();
        }
    });
});