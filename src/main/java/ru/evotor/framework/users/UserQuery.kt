package ru.evotor.framework.users

import android.content.Context
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

class UserQuery(authenticatedUsersOnly: Boolean = false) : FilterBuilder<UserQuery, UserQuery.SortOrder, User?>(
        if (authenticatedUsersOnly) UsersTable.URI_AUTHENTICATED else UsersTable.URI) {
    override val currentQuery: UserQuery
        get() = this

    @JvmField
    val uuid = addFieldFilter<String>(UsersTable.ROW_USER_UUID)
    @JvmField
    val secondName = addFieldFilter<String?>(UsersTable.ROW_USER_SECOND_NAME)
    @JvmField
    val firstName = addFieldFilter<String?>(UsersTable.ROW_USER_FIRST_NAME)
    @JvmField
    val inn = addFieldFilter<String?>(UsersTable.ROW_USER_INN)
    @JvmField
    val phone = addFieldFilter<String?>(UsersTable.ROW_USER_PHONE)
    @JvmField
    val pin = addFieldFilter<String?>(UsersTable.ROW_USER_PIN)
    @JvmField
    val roleUuid = addFieldFilter<String>(UsersTable.ROW_ROLE_UUID)
    @JvmField
    val roleTitle = addFieldFilter<String>(UsersTable.ROW_ROLE_TITLE)

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        override val currentSortOrder: SortOrder
            get() = this

        @JvmField
        val uuid = addFieldSorter(UsersTable.ROW_USER_UUID)
        @JvmField
        val secondName = addFieldSorter(UsersTable.ROW_USER_SECOND_NAME)
        @JvmField
        val firstName = addFieldSorter(UsersTable.ROW_USER_FIRST_NAME)
        @JvmField
        val inn = addFieldSorter(UsersTable.ROW_USER_INN)
        @JvmField
        val phone = addFieldSorter(UsersTable.ROW_USER_PHONE)
        @JvmField
        val pin = addFieldSorter(UsersTable.ROW_USER_PIN)
        @JvmField
        val roleUuid = addFieldSorter(UsersTable.ROW_ROLE_UUID)
        @JvmField
        val roleTitle = addFieldSorter(UsersTable.ROW_ROLE_TITLE)

    }

    override fun getValue(context: Context, cursor: Cursor<User?>): User? {
        return UserMapper.createUser(cursor)
    }

}
