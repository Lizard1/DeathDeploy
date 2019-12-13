package hibernate.service.serv;

import hibernate.controller.AccountController;
import hibernate.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

/*    @Mock
    private AccountService accountService;
    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    @Test
    public void getAccount() throws Exception {

    }*/

   /* private MockMvc mockMvc;
    private final AccountController controller = new AccountController();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(404))
                .andExpect(view().name("user")); // проверка имени view, котрый вернул action
                //.andExpect(model().attribute("foo", bar")); // проверка атрибута модели
    }*/

 /*   @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testCreateSignupFormInvalidUser() throws Exception {
        this.mockMvc.perform(get("/")).andExpect(status().isOk());
    }*/

    @Mock
    private UserService userService;
    @Mock
    private AccountService accountService;

    @InjectMocks
    private UserController userController;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvcUser;
    private MockMvc mockMvcContr;

    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        // Setup Spring test in standalone mode
        this.mockMvcUser = MockMvcBuilders.standaloneSetup(userController).build();
        this.mockMvcContr = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
    public void testPathToUser() throws Exception {
        mockMvcUser.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("user"));
    }

    @Test
    public void testPathUserIsTwoHundred() throws Exception {
        mockMvcUser.perform(get("/"))
                .andExpect(status().is(200));
    }

    @Test
    public void testPathToUserNegative() throws Exception {
        mockMvcUser.perform(get("/negative"))
                .andExpect(status().is(404));
    }

    @Test
    public void usersList() throws Exception{
        ResultActions result = mockMvcUser.perform(MockMvcRequestBuilders.get("/"));

        result.andExpect(MockMvcResultMatchers.view().name("user"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("usersList"));
    }

    @Test
    public void oneUser() throws Exception{
        ResultActions result = mockMvcUser.perform(MockMvcRequestBuilders.get("/user/2"));

        result.andExpect(MockMvcResultMatchers.view().name("user"));
        //result.andExpect(MockMvcResultMatchers.model().attributeExists("oneUser"));
    }


    @Test
    public void testPathToAccount() throws Exception {
        mockMvcContr.perform(get("/account"))
                .andExpect(status().isOk())
                .andExpect(view().name("account"));
    }

    @Test
    public void accountsList() throws Exception{
        ResultActions result = mockMvcContr.perform(MockMvcRequestBuilders.get("/account"));

        result.andExpect(MockMvcResultMatchers.view().name("account"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("accountsList"));
    }

    @Test
    public void oneAccount() throws Exception{
        ResultActions result = mockMvcContr.perform(MockMvcRequestBuilders.get("/account/2"));

        result.andExpect(MockMvcResultMatchers.view().name("account"));
        result.andExpect(MockMvcResultMatchers.model().attributeExists("oneAccount"));
    }



}
