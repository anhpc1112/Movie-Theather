import styles from "./index.module.css";
// import "@fortawesome/fontawesome-common-type";

export default function LoginPage() {
  return (
    <div className={styles.main}>
      <div className={styles.boxForm}>
        <div className={styles.left}>
          <div className={styles.overlay}>
            <h1>Hello World.</h1>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur
              et est sed felis aliquet sollicitudin
            </p>
            <span>
              <p>login with social media</p>
              <a href="#def">
                <i className="fa fa-facebook" aria-hidden="true" />
              </a>
              <a href="#abc">
                <i className="fa fa-twitter" aria-hidden="true" />
              </a>
            </span>
          </div>
        </div>

        <div className={styles.right}>
          <h5>Login</h5>
          <p>
            <span>Don't have an account?</span>
            <a href="#xyz">Creat Your Account</a>
            <br />
            <span>it takes less than a minute</span>
          </p>
          <div className={styles.formLogin}>
            <div>
              <label>Email</label>
              <label>Password</label>
            </div>
            <div>
              <input type="text" placeholder="email" />
              <input type="password" placeholder="password" />
            </div>
          </div>

          <br></br>

          <div className="remember-me--forget-password">
            <label className={styles.label}>
              <input type="checkbox" name="item" checked />
              <span className={styles.textCheckbox}>Remember me</span>
            </label>
            <p>forget password?</p>
          </div>

          <br />
          <button>Login</button>
        </div>
      </div>
    </div>
  );
}
