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
    'ngMaterial'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'vm'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'vm'
      })
      .when('/profile', {
        templateUrl: 'views/profile.html',
        controller: 'ProfileCtrl',
        controllerAs: 'vm'
      })
      .when('/kids', {
        templateUrl: 'views/kids.html',
        controller: 'KidsCtrl',
        controllerAs: 'vm'
      })
      .when('/kidsProfile/:idkid', {
        templateUrl: 'views/kidsProfile.html',
        controller: 'kidsProfileCtrl',
        controllerAs: 'vm'
      })
      .when('/kidsAdd', {
        templateUrl: 'views/kidsAdd.html',
        controller: 'kidsAdd',
        controllerAs: 'vm'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
