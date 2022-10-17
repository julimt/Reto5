const urlR = "http://localhost:8080/api/Room"

$(document).ready(function() {
    getRoom()
})
;
function getRoom(){
    let tam = 0;
    $.ajax({
        url: urlR + "/all",
        type: 'GET',
        dataType:  'JSON',
        success: function(data) {
            let tam = data.length
            if (tam == 0) {
                $("#contenedor").hide()
                $("#mensaje").show()
            } else {
                $("#contenedor").show()
                $("#mensaje").hide()
                $("#numregistroR").html("Numero de Registros: " + tam)
                console.log(data)
                let registro = ""
                $.each(data, function (index, room) {
                    registro += "<tr>"+
                                "<td>" + room.id +"</td>" +
                                "<td>" + room.name + "</td>" +
                                "<td>" + room.hotel + "</td>" +
                                "<td>" + room.stars + "</td>" +
                                "<td>" + room.description + "</td>" +
                                "<td><button data-bs-toggle='modal'data-bs-target='#modalactualizar' class='btn btn-warning'" +
                                "onclick=\"enviar('"+ room.id +"','"+
                                room.name +"','"+ room.hotel +"','"+
                                room.stars +"','"+ room.description +"')\"" +
                                ">Editar</button>&nbsp" +
                                "<td><button class='btn btn-danger'onclick=\"eliminar(\'" +
                                room.id +
                                "\')\">Eliminar</button></td>"
                            "</tr>"
                })
                console.log(registro)
                $("#tbody").html(registro)
            }
        }
    })
}

function enviar(id,name,hotel,stars,description){
    console.log(id)
    console.log(name)
    console.log(hotel)
    console.log(stars)
    console.log(description)

    let room = {
        name: $("#name").val(),
        hotel: $("#hotel").val(),
        stars: $("#stars").val(),
        description: $("#description").val()
    }
    console.log(room)
    let dataJson = JSON.stringify(room);
    console.log(dataJson)
    $.ajax({
        url: urlR + "/update",
        type: "PUT",
        data: dataJson,
        contentType: "application/json",
        complete: function(data) {
            console.log(data)
            if (data.status == "201"){
                alert("Actualizó Registro Habitación con Exito!!")
            } else {
                alert("Problemas al Insertar, Consulta al Administrador!!")
            }
        }
    })
}

function eliminar(id) {
    if (confirm("Desea Eliminar el Registro con id room " + id + "?")) {

        $.ajax({
            url: urlR+ "/" + id,
            type: "DELETE",
            dataType: "JSON",
            contentType: "applicaation/json",
            complete: function(){
                getRoom()
            }

        })
    }
}