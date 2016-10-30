/**
 * Created by ASUS on 29/10/2016.
 */
angular.module('starter')

  .constant('AUTH_EVENTS', {
    notAuthenticated: 'auth-not-authenticated',
    notAuthorized: 'auth-not-authorized'
  })

  .constant('USER_ROLES', {
    admin: 'admin_role',
    paciente: 'public_role'
  });
