// Esta función mostrará la tabla de detalles y ocultará el botón "Ver más"
function mostrarTablaDiag(element) {
    const tablaDetalles = element.nextElementSibling;
    const verMasBtn = element;
    const verMenosBtn = element.nextElementSibling.nextElementSibling;

    tablaDetalles.style.display = 'table';
    verMasBtn.style.display = 'none';
    verMenosBtn.style.display = 'inline';
}

// Esta función ocultará la tabla de detalles y mostrará el botón "Ver más"
function ocultarTabla(element) {
    const tablaDetalles = element.previousElementSibling;
    const verMasBtn = element.previousElementSibling.previousElementSibling;
    const verMenosBtn = element;

    tablaDetalles.style.display = 'none';
    verMasBtn.style.display = 'inline';
    verMenosBtn.style.display = 'none';
}