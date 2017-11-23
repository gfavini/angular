/* global appCliente */

//criação do controler
appCliente.controller('clienteController', function($scope, $http){
    $scope.nome = "Gustavo";
    $scope.sobreNome = "Favini";
    $scope.clientes = [];
    $scope.cliente={};
    $scope.estados = [];
    
    caregarClientes = function(){
        //token = localStorage.getItem("userToken");
        //$http.defaults.headers.common.Authorization = 'Bearer '+token;
        $http({method:'GET', url: '/admin/clientes'})
            .then(function successCallback(response){
                //Sucesso
                console.log(response.data);
                console.log(response.status);
                $scope.clientes = response.data;

            }, function errorCallback(response){
                console.log(response.data);
                console.log(response.status);
                //Falha
            });
    };
    
    carregarEstados = function (){
        $http.get("estados")
        .then(
            function successCallback (response){
               $scope.estados = response.data;
               console.log(response.data);
            }, 
            function errorCallback (response){
                console.log(response);
         });
     };
    
    
    caregarClientes();
    carregarEstados();
    

    $scope.salvarCliente = function(form){
        if($scope.frmClientes.$valid){
        $http({method:'POST', url: '/admin/clientes',
                data: $scope.cliente
                })
            .then(function successCallback(response){
                //Sucesso
                console.log(response.data);
                console.log(response.status);

                //$scope.clientes = response.data;
                caregarClientes();
                $scope.cancelarCliente();
                
                //$scope.clientes.push(response.data);
                
                
            }, function errorCallback(response){
                console.log(response.data);
                console.log(response.status);
                //Falha
            });
            $scope.cancelarCliente(form);
        }else{
            window.alert("Dados inválidos");
        }
    };
        $scope.excluirCliente = function(cli, form){        
            $http({method:'DELETE', url: '/admin/clientes/' + cli.id,
                data: $scope.cliente
                })
            .then(function successCallback(response){
                //Sucesso
                console.log(response.data);
                console.log(response.status);
                
                var index = $scope.clientes.indexOf(cli);
                $scope.clientes.splice(index, 1);

                //$scope.clientes = response.data;
                //$scope.clientes.push(response.data);
                
            }, function errorCallback(response){
                console.log(response.data);
                console.log(response.status);
                //Falha
            });

        };
        
        $scope.alterarCliente = function(cli){            
            $scope.cliente = angular.copy(cli);
        };        
        $scope.cancelarCliente = function(form){            
            $scope.cliente = {};
            form.$setPristine();
            form.$setUntouched();
        }; 
}); 


