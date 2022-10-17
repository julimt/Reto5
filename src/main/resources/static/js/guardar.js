const urlR = "http://localhost:8080/api/Room"


$(document).ready(function() {

    $("#guardar").click(function(){
        guardarRoom()
    })
})

function guardarRoom() {

    let room = {
        name: $("#name").val(),
        hotel: $("#hotel").val(),
        stars: $("#stars").val(),
        description: $("#description").val()
    }
    console.log(room)
    if (room.name.length == 0 || room.hotel.length == 0 ||
        room.stars.length == 0  || room.description.length == 0) {
        alert("Campo(s) Vacío(s)")
    }
    //console.log(room)
    if (room.name.length > 45) {
        alert("Campo nombre no puede ser mayor a 45 caracteres")
    }
    if (room.stars.length > 5) {
        alert("Campo estrellas no puede ser mayor a 5 caracteres")
    }
    if(room.description.length > 250) {
        alert("La descripción tiene que ser menor a 250 caracteres")
    }
    if (room.name.length <= 45 && room.hotel.length > 0 && room.stars.length >= 1 &&
        room.stars.length >= 5 && room.description.length <= 250) {
        let dataJson = JSON.stringify(room);
        console.log(dataJson)
        $.ajax({
            url: urlR + "/save",
            type: "POST",
            data: dataJson,
            contentType: "application/json",
            complete: function(data) {
                console.log(data)
                if (data.status == "201"){
                    alert("Guardo Registro Habitación con Exito!!")
                } else {
                    alert("Problemas al Insertar, Consulta al Administrador!!")
                }
            }
        })
    }
}

