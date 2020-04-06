package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView(): UserView {

    val nickName = ""
    val initials = ""

    val status =
        when {
            lastVisit == null -> "Еще не разу не был"
            isOnline -> "online"
            else -> "Последний раз был ${lastVisit}"
        }
    //TODO ${lastVisit.humanizeDiff()


    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status)
}