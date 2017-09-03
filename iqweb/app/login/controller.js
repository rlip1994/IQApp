(function () {
    'use strict';

    angular
        .module('smart')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function LoginController($location, AuthenticationService, FlashService) {
        var vm = this;
        vm.login = login;

        init();



        function init() {

        }

        function login() {
            console.dir(loginForm);
        }

    }

})();