'use strict';

/**
 * @ngdoc overview
 * @name iqwebApp
 * @description
 * # iqwebApp
 *
 * Main module of the application.
 */
angular
  .module('iqwebApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngMaterial',
    'ngCookies'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        resolve:{
          "check": function($location,$cookieStore){
            if(angular.isUndefined($cookieStore.get('idUser'))){
                $location.path('/login');
            }
          }
        },
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'vm'
      })
      .when('/help', {
        templateUrl: 'views/help.html',
        controller: 'AboutCtrl',
        controllerAs: 'vm'
      })
      .when('/profile', {
        resolve:{
          "check": function($location,$cookieStore){
            if(angular.isUndefined($cookieStore.get('idUser'))){
                $location.path('/login');
            }
          }
        },
        templateUrl: 'views/profile.html',
        controller: 'ProfileCtrl',
        controllerAs: 'vm'
      })
      .when('/kids', {
        resolve:{
          "check": function($location,$cookieStore){
            if(angular.isUndefined($cookieStore.get('idUser'))){
                $location.path('/login');
            }
          }
        },
        templateUrl: 'views/kids.html',
        controller: 'KidsCtrl',
        controllerAs: 'vm'
      })
      .when('/kidsProfile/:idkid', {
        resolve:{
          "check": function($location,$cookieStore){
            if(angular.isUndefined($cookieStore.get('idUser'))){
                $location.path('/login');
            }
          }
        },
        templateUrl: 'views/kidsProfile.html',
        controller: 'kidsProfileCtrl',
        controllerAs: 'vm'
      })
      .when('/kidsAdd', {
        resolve:{
          "check": function($location,$cookieStore){
            if(angular.isUndefined($cookieStore.get('idUser'))){
                $location.path('/login');
            }
          }
        },
        templateUrl: 'views/kidsAdd.html',
        controller: 'kidsAdd',
        controllerAs: 'vm'
      })
      .when('/results', {
        resolve:{
          "check": function($location,$cookieStore){
            if(angular.isUndefined($cookieStore.get('idUser')) || !$cookieStore.get('isAdmin') ){
                $location.path('/login');
            }
          }
        },
        templateUrl: 'views/results.html',
        controller: 'resultsCtrl',
        controllerAs: 'vm'
      })
      .when('/register', {
        resolve:{
          "check": function($location,$cookieStore){
            if(!angular.isUndefined($cookieStore.get('idUser'))){
                $location.path('/');
            }
          }
        },
        templateUrl: 'views/register.html',
        controller: 'RegisterCtrl',
        controllerAs: 'vm'
      })
      .when('/login', {
        resolve:{
          "check": function($location,$cookieStore){
            if(!angular.isUndefined($cookieStore.get('idUser'))){
                $location.path('/');
            }
          }
        },
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'vm'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
