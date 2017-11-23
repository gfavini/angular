/* global appCliente */

appCliente.controller('clienteDetalheController', function($scope, $http, $routeParams){
    
    var clienteId = $routeParams.clienteId;
    $scope.cliente={};
    
    $http.get("clientes/id/"+clienteId)
        .then(
            function successCallback (response){
               $scope.cliente = response.data;
               console.log(response.data);
            }, 
            function errorCallback (response){
                console.log(response)
         })
});


