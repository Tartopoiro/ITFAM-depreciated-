// Initialisation après chargement du DOM
document.addEventListener("DOMContentLoaded", function() {
    const monBouton = document.getElementById('confirm');

    monBouton.addEventListener('click', function(event) {
        const element = this;
        customConfirm("Veuillez confirmer", function(result) {
            if (result) {
                // Redirection vers le lien du bouton
                window.location.href = element.getAttribute('href');
            } else {
                // Annulation de l'action par défaut du bouton
                event.preventDefault();
            }
        });
    });
});




