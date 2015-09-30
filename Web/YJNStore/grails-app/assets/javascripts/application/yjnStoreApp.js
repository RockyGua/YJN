'use strict';

try {
    angular.module("yjnStoreApp");
    throw 'App is already initialized, exiting';
} catch (err) {
    /* failed to require This is expected if the app isn't yet loaded.*/
}

var yjnStoreAppModule = angular.module("yjnStoreApp", ["ngRoute", "healthCheckControllers"]);
yjnStoreAppModule.constant("module", {});
yjnStoreAppModule.config(function ($routeProvider, $locationProvider) {
    $routeProvider.
        when("/", {
            templateUrl: '/YJNStore/template/healthCheck',
            controller: 'HealthCheckCtrl'
        });

    $locationProvider.html5Mode(true);

});
//yjnStoreAppModule.run(function($rootScope) {
//        alert("sdadadadadad");
//    });