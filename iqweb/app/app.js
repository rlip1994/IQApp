'use strict';

// Declare app level module which depends on views, and components
angular.module('smart', [
  'ngRoute',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
 

  $routeProvider

  .when('/login',{
    controller: 'LoginController',
    templateUrl: 'login/view.html',
    controllerAs: 'vm'
  })
  
  .when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl',
    controllerAs: 'vm'
  })

  .when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl',
    controllerAs: 'vm'
  })

  
  .otherwise({redirectTo: '/view1'});
}]);
