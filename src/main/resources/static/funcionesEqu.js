function eliminarEquip(id){
    swal({
        title: "Seguro que desea eliminar?",
        text: "ATENCIÓN, eliminará el registro, Si posee ordenes no se eliminara!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({url:"/eliminar2/"+id,
                    success: function (res){
                        console.log(res);
                    }

                });
                swal("Listo!El registro a sido eliminado!", {
                    icon: "success",
                }).then((ok)=>{
                    if (ok){
                        location.href="/listar2";
                    }
                });
            } else {
                swal("Eliminación cancelada!");
            }
        });
}

