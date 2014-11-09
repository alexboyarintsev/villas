(function() {
    var app = angular.module('app', []);

    app.controller('VillasController', ['$http', function($http) {
        var app = this;
        app.villas = [];

        $http.get('http://localhost:8080/admin/villas').success(function(data) {
            app.villas = data;
        });

    }]);



})();
