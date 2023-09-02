function mostrarTablaDiag(btn) {
    var tablaDetalles = btn.parentNode.parentNode.querySelector(".tabla-detalles");
    var verMenosBtn = btn.parentNode.querySelector(".ver-menos-btn");

    tablaDetalles.style.display = "table";
    verMenosBtn.style.display = "inline-block";
    btn.style.display = "none";
}

function ocultarTabla(btn) {
    var tablaDetalles = btn.parentNode.parentNode.querySelector(".tabla-detalles");
    var verMasBtn = btn.parentNode.querySelector(".ver-mas-btn");

    tablaDetalles.style.display = "none";
    verMasBtn.style.display = "inline-block";
    btn.style.display = "none";
}