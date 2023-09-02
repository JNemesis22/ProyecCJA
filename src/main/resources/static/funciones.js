function eliminar (id){
    swal({
        title: "Seguro que desea eliminar?",
        text: "ATENCIÓN, eliminará el registro y no lo podrá recuperar!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({url:"/eliminar/"+id,
                    success: function (res){
                    console.log(res);
                    }

                });
                swal("Listo!El registro a sido eliminado!", {
                    icon: "success",
                }).then((ok)=>{
                    if (ok){
                        location.href="/listar";
                    }
                });
            } else {
                swal("Eliminación cancelada!");
            }
        });
}
