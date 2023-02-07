package com.example.page_login.ViewModel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.page_login.BR;
import com.example.page_login.Model.User;

public class LoginViewModel extends BaseObservable {


    // création d'un objet de la classe Model
    private User user;
    // variables de chaîne pour
// les messages de toast
    private String successMessage = "Login successful";
    private String errorMessage = "Email or Password is not valid";
    @Bindable
// variable de chaîne pour
// le message du toast
    private String toastMessage = null;

    // méthodes getter et setter
// pour le message du toast
    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    // méthodes getter et setter
// pour la variable email
    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    // méthodes getter et setter
// pour la variable password
    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel() {
// instanciation d'un objet de
// classe de modèle
        user = new User("othmanepro123@gmail.com", "133742");
    }

    // actions à effectuer
// lorsque l'utilisateur clique sur
// le bouton Connexion
    public void onButtonClicked() {
        if (isValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    // méthode permettant de vérifier
// que les champs variables ne doivent
// pas être laissés vides par l'utilisateur
    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }
}







