const init = () => {

    // let appStart = () => {
    //     gapi.load('auth2', initSigninV2);
    // }

    //
    // let initSigninV2 = () => {
    //     let auth2 = gapi.auth2.init({
    //         client_id: "957495172888-dktv6coic4ctb7m9gchun82luk9q317d.apps.googleusercontent.com"
    //     });
    //
    //     // TODO: add listeners as needed
    //     // https://developers.google.com/identity/sign-in/web/listeners
    //
    //
    // }

}

const onSignIn = (googleUser) => {
    let profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

    let idToken = googleUser.getAuthResponse().id_token;

    // Send idToken to server with POST request
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'https://localhost:8080/tokenSignIn');
    // xhr.open('POST', 'http://ec2-18-217-107-47.us-east-2.compute.amazonaws.com:8080/ccb/tokensignin');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = function() {
        console.log('Signed in as: ' + xhr.responseText);
    };
    xhr.send('idToken=' + idToken);
}

function signOut() {
    let auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
}

