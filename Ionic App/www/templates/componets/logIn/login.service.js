'use strict';

/* globals baymaxPiApp */
baymaxPiApp.factory('LoginService', [ '$resource',
  function ($resource) {
    var url = 'singleWindow/requests';
    var defaultParams = {};

    var actions = {

      getRequest: {method: 'GET', isArray: true,
      },
    };

    return $resource(url, defaultParams, actions);
  },
]);
