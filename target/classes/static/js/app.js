//Criação do modulo principal da aplicação
var appCliente = angular.module("appCliente", ['ngRoute']);

appCliente.controller('MainController', function($scope, $route, $routeParams, $location) {
        $scope.$route = $route;
        $scope.$location = $location;   
        $scope.$routeParams = $routeParams;
 });

appCliente.config(function($routeProvider,  $locationProvider){
    //cria rotas a serem seguitas e determina o template a ser usado assim como o controlador
    $routeProvider
            .when('/clientes',{templateUrl:'view/cliente.html', controller:'clienteController'})
            .when('/clientes/:clienteId',{templateUrl:'view/cliente-detalhe.html', controller:'clienteDetalheController'})
            .when('/cidade',{templateUrl:'view/cidade.html', controller:'cidadeController'})
            .when('/estado',{templateUrl:'view/estado.html', controller:'estadoController'})
            .when('/login',{templateUrl:'view/login.html', controller:'loginController'})
            .otherwise({redirectTo:'/'});//otherwise é usado para determinar a rota padrão caso rota invaldiade seja colcoada
    $locationProvider.html5Mode(true);
});
appCliente.config(function($httpProvider){
    $httpProvider.interceptors.push("tokenInterceptor");
});