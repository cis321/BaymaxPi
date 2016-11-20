'use strict';

/* globals baymaxPiApp */
baymaxPiApp.factory('LoginService', ['$resource',
    function ($resource) {
        var url = 'http://192.168.43.178:9050/server-baymaxpi/api/authorization';
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
        };

        return $resource(url, defaultParams, actions);
    },
]);
