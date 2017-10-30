'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('KidsCtrl', function($scope, $http) {


    var vm = this;

    vm.start = start;
    vm.search = search;
    vm.clearSearch = clearSearch;
    vm.kids;
    vm.KidsBackup;
    vm.searchType = ["Escuela", "Grado", "Identificacion", "Region"];



    function start() {
      $http.get('http://andresolis-littlestark.c9users.io:8080/getAllKids/7').then(function(response) {

        $scope.vm.kids = response.data[0];
      });
    }

    function search() {
      if (vm.selectedSearchType && vm.searchItem) {
        var selectedKey = rename();
        vm.KidsBackup = vm.kids;
        vm.kids = [];

        for (var i = 0, len = vm.KidsBackup.length; i < len; i++) {
          var player = vm.KidsBackup[i];
          for (var key in player) {
            if (selectedKey === key) {
              var allKidsLower = player[key].toLowerCase();
              var searchLower = vm.searchItem.toLowerCase();
              console.dir(allKidsLower.indexOf(searchLower));
              if (allKidsLower.indexOf(vm.searchItem.toLowerCase()) + 1) {
                vm.kids.push(player);
              }
            }
          }
        }
      }

    }

    function clearSearch() {
      vm.kids = vm.KidsBackup;
      vm.searchItem = '';
      vm.selectedSearchType = undefined;
    }

    function rename() {
      if (vm.selectedSearchType === "Escuela") {
        return "school";
      }
      if (vm.selectedSearchType === "Grado") {
        return "grade";
      }
      if (vm.selectedSearchType === "Identificacion") {
        return "idCard";
      }
      if (vm.selectedSearchType === "Region") {
        return "country";
      }
    }


  });
