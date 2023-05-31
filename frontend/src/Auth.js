import { useContext, useEffect } from "react";
import { useNavigate } from "react-router";
import { UserContext } from "./context/UserContext";
import axios from "axios";

// Auth component validate user authentication
// befor give access to the others pages
const Auth = (props) => {
  const navigate = useNavigate();
  const [user, setUser] = useContext(UserContext);

  useEffect(() => {
    // retreive token from session storage
    let token = localStorage.getItem("token");

    if (token == undefined || token === "") {
      navigate("/login");
    } else {
      setUser(null);
      // Fetch the authenticated user data
      axios
        .get("/users", { params: { email: "test@test.fr" } })
        .then((data) => setUser(data))
        .catch(() => {
          // If the token is expired or not valid
          // it push to user back to the login page
          localStorage.removeItem("token");
          navigate("/login");
        });
    }
    // eslint-disable-next-line
  }, []);

  // wait till the user data are fetched successfully
  return (
    <>{user === null || user == undefined ? "LOADING ..." : props.children}</>
  );
};

export default Auth;
