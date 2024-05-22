$(document).ready(function () {
    function obtenerMunicipios(estadoId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                url: 'api/municipios/' + estadoId,
                method: 'GET',
                success: function (data) {
                    var municipioSelect = $('#municipio');
                    municipioSelect.empty();
                    municipioSelect.append('<option value="">Seleccione el estado...</option>');
                    $.each(data, function (key, value) {
                        municipioSelect.append('<option value="' + value.id.clave + '">' + value.descripcion + '</option>');
                    });
                    resolve();
                },
                error: function (error) {
                    alert('Error al cargar los municipios:');
                    reject(error);
                }
            });
        });
    }

    function obtenerLocalidades(estadoId) {
        return new Promise((resolve, reject) => {
            $.ajax({
                url: 'api/localidades/' + estadoId,
                method: 'GET',
                success: function (data) {
                    var localidadSelect = $('#localidad');
                    localidadSelect.empty();
                    localidadSelect.append('<option value="">Seleccione el municipio...</option>');
                    $.each(data, function (key, value) {
                        localidadSelect.append('<option value="' + value.id.clave + '">' + value.descripcion + '</option>');
                    });
                    resolve();
                },
                error: function (error) {
                    alert('Error al cargar las localidades:');
                    reject(error);
                }
            });
        });
    }

    $('#cp').blur(function() {
        let cp = $(this).val();
        $.ajax({
            url: '/api/codigo-postal/' + cp,
            method: 'GET',
            success: function(data) {
                console.log(data)
                let coloniasSelect = $('#colonias');
                coloniasSelect.empty();
                $.each(data.colonias, function(index, colonia) {
                    coloniasSelect.append('<option value="' + colonia.id.clave + '">' + colonia.descripcion + '</option>');
                });

                $('#estado').val(data.estado.clave).change();

                obtenerMunicipios(data.estado.clave).then(() => {
                    $('#municipio').val(data.municipio.id.clave).change();
                    obtenerLocalidades(data.estado.clave).then(() => {
                        $('#localidad').val(data.localidad.id.clave).change();
                    }).catch((error) => {
                        console.log('Error al obtener las localidades:', error);
                    });
                }).catch((error) => {
                    console.log('Error al obtener los municipios:', error);
                });
            },
            error: function() {
                alert('Código postal no encontrado');
            }
        });
    });

    $('#estado').change(function () {
        var estadoId = $(this).val();
        obtenerMunicipios(estadoId).then(() => {
            obtenerLocalidades(estadoId).then(() => {
            }).catch((error) => {
                console.log('Error al obtener las localidades:', error);
            });
        }).catch((error) => {
            console.log('Error al obtener los municipios:', error);
        });
    });

    $('form').submit(function(event) {
        event.preventDefault();
        let formData = {
            cp: $('#cp').val(),
            estadoId: $('#estado').val(),
            municipioId: $('#municipio').val() === "" ? null : $('#municipio').val(),
            localidadId: $('#localidad').val() === "" ? null : $('#localidad').val(),
            coloniaId: $('#colonias').val() === "" ? null : $('#colonias').val()
        };

        $.ajax({
            url: '/api/validar-direccion',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                alert(response);
            },
            error: function(response) {
                alert('Error: ' + response.responseText);
            }
        });
    });
});
