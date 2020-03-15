const init = () => {

    let appStart = () => {
        gapi.load('auth2', initSigninV2);
    }


    let initSigninV2 = () => {
        auth2 = gapi.auth2.init({
            client_id: "957495172888-dktv6coic4ctb7m9gchun82luk9q317d.apps.googleusercontent.com",
            scope: "profile"
        });

        // TODO: add listeners
        // https://developers.google.com/identity/sign-in/web/listeners

    }




}