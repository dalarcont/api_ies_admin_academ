package com.ies.ies_admin_academ;

import com.ies.ies_admin_academ.GET.USERS.GetUserTest;
import com.ies.ies_admin_academ.PATCH.PatchUserTest;
import com.ies.ies_admin_academ.POST.USERS.PostUserTest;
import com.ies.ies_admin_academ.PUT.USERS.PutUserTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		GetUserTest.class,
		PostUserTest.class,
		PatchUserTest.class,
		PutUserTest.class
})
public class IESAdminAcademApplicationTests {

}
