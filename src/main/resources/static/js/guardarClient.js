const urlC = "http://localhost:8080/api/Client"


$(document).ready(function() {

    $("#guardar").click(function(){
        guardarClient()
    })
})

function guardarClient() {

    let client = {
        email: $("#email").val(),
        password: $("#password").val(),
        name: $("#name").val(),
        age: $("#age").val()
    }
    //console.log(cliente)
    if (client.email.length == 0 || client.password.length == 0 ||
        client.name.length == 0  || client.age.length == 0) {
        alert("Campo(s) Vacío(s)")
    }
    //console.log(cliente)
    if (client.email.length > 45) {
        alert("Campo Email no puede ser mayor a 45 caracteres")
    }
    if(client.password.length >= 1 && client.password.length <=4) {
        alert("El password tiene que ser Mayor a 4 caracteres")
    }
    if (client.email.length <= 45 && client.password.length > 4 &&
        client.name.length > 0 && client.age.length > 0) {
        let dataJson = JSON.stringify(client)
        console.log(dataJson)
        $.ajax({
            url: urlC + "/save",
            type: "POST",
            data: dataJson,
            contentType: "application/json",
            complete: function(data) {
                if (data.status == "201"){
                    alert("Guardo Registro Cliente con Exito!!")
                } else {
                    alert("Problemas al Insertar, Consulta al Administrador!!")
                }
            }
        })
    }
}