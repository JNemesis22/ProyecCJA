function borrar (id){
    swal({
        title: "Seguro que desea eliminar?",
        text: "ATENCIÓN, eliminará el registro y no lo podrá recuperar!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({url:"/eliminarDiag/"+id,
                    success: function (res){
                        console.log(res);
                    }

                });
                swal("Listo!El registro a sido eliminado!", {
                    icon: "success",
                }).then((ok)=>{
                    if (ok){
                        location.href="/listarDiag";
                    }
                });
            } else {
                swal("Eliminación cancelada!");
            }
        });
}
