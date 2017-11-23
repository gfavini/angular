/* global appCliente */

appCliente.controller('loginController', function($scope, $http){
    
    $scope.usuario={};
    
    $scope.token = {};
    
    $scope.autenticar = function(){
//        console.log('Chemou submit ' + $scope.usuario.nome);
        $http.post("/autenticar",$scope.usuario)
            .then(function successCallback(response){
                console.log("Sucessoo "+response);
                $scope.token = response.data.token;
                /*salva no browser o token que esta chegando da API*/
                localStorage.setItem("userToken", response.data.token);
        
            },function errorCallback(response){
                console.log("Falha "+response);
                
            }
        );
        
    };
    
    
}); 