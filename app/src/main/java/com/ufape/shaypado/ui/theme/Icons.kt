package com.ufape.shaypado.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ufape.shaypado.R

@Composable
@Preview
fun KeyIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_key),
        contentDescription = "Password"
    )
}

@Composable
@Preview
fun EyeIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_eye),
        contentDescription = "Password"
    )
}

@Composable
@Preview
fun EyeSlashIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_eye_slash),
        contentDescription = "Password"
    )
}



@Composable
@Preview
fun AtIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_at),
        contentDescription = "Email"
    )
}

@Composable
@Preview
fun UserIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_user),
        contentDescription = "Username"
    )
}

@Composable
@Preview
fun UserOutlinedIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_user_outlined),
        contentDescription = "Password"
    )
}

@Composable
@Preview
fun SmilingFaceIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_smilling_face),
        contentDescription = "Smiling Face"
    )
}

@Composable
@Preview
fun BackIcon(){
    Icon(
        tint = textSecondary,
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = "Back"
    )
}

@Composable
@Preview
fun ShaypadoImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_shaypado_name),
        contentDescription = "Shaypado"
    )
}

@Composable
@Preview
fun GoogleImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_google),
        contentDescription = "Google"
    )
}

@Composable
@Preview
fun ShaypadoPetImage(){
    Image(
        painter = painterResource(id = R.drawable.brand_logo),
        contentDescription = "Shaypado logo"
    )
}