import styles from "./page.module.css";

export default function LoginPage() {
    return (
        <main className={styles.main}>
            <h1>Login Page</h1>
            <label>Email</label>
            <input type="text" name="email"></input>
            <label>Password</label>
            <input type="password" name="password"></input>
        </main>
    );
}
