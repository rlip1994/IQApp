'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp')
  .controller('ProfileCtrl', function ($scope,$http) {
  

    this.editProfile=editProfile;
    this.cancelUpdate=cancelUpdate;
    this.acceptUpdate=acceptUpdate;
    this.start=start;


    this.edit=true;
    this.btnAcceptCancel=false;
    this.passwordNew = false;
    this.passwordConfirm = false;
    this.user;
    



    function start(){
      $http.get('http://localhost:3000/userProfile/1').then(function(response){
        
        $scope.vm.user=response.data[0][0];
      });
    }

    function editProfile(){
      this.edit = false;
      this.btnAcceptCancel = !this.edit;
      this.passwordNew = !this.edit;
      this.passwordConfirm = !this.edit;

      $http.get('http://localhost:3000/userProfile/1').then(function(response){
        console.log(response.data[0][0]);
        $scope.vm.user=response.data[0][0];
      });
      
    }

    function cancelUpdate(){
      this.edit = true;
      this.btnAcceptCancel = !this.edit;
      this.passwordNew = !this.edit;
      this.passwordConfirm = !this.edit;
    }

    function acceptUpdate(){
      
      
      $http.post('http://localhost:3000/userProfileMod',this.user).then(function(response){
        //console.log(response.data);
      });
    }

   


  }
);
