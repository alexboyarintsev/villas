/**
 * Created by shamp_000 on 16.11.2014.
 */
(function() {
    var reservations = angular.module('reservations', []);

    reservations.controller('ReservationsController', ['$http', function($http) {
        this.reservation = {};

        this.addReservation = function() {
            $http.post('http://localhost:8080/reservations', {reservation : this.reservation}).
                success(function(data, status, headers, config) {
                    alert('success');
                }).
                error(function(data, status, headers, config) {
                    alert('error');
                });
            this.reservation = {};
        };

    }]);



})();
