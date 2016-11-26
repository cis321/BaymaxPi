'use strict';

/* globals baymaxPiApp */
baymaxPiApp.factory('LoginService', ['$resource',
    function ($resource) {
        var url = 'http://localhost:9050/server-baymaxpi/api/authorization';
        var defaultParams = {};

        var actions = {
            createUser: {
                method: 'POST',
                isArray: false,
            },
            login: {
              method: 'GET',
              isArray: false,
            },
            updateUser: {
                method: 'POST',
                isArray: false,
                url: url + '/updateUser',
            },
        };

        return $resource(url, defaultParams, actions);
    },
]);
