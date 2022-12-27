//
// npm run new:sfc -- --tag=p
//
module.exports = {
  prompt: ({ inquirer, args }) => {
    const questions = [
      {
        type: "input",
        name: "page_name",
        message: "What is the name of page?",
      },
    ];
    return inquirer.prompt(questions).then(({ page_name }) => {
      const absCwd = process.env.NODENV_DIR || process.env.INIT_CWD;
      const cwd = absCwd.replace(`${process.cwd()}/`, "");
      const output_path = cwd;
      const page_path = `${cwd.replace("src/pages/", "")}/${page_name}`;
      return {
        output_path,
        page_name,
        page_path,
      };
    });
  },
};
