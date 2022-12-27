//
// npm run new:sfc -- --tag=p
//
module.exports = {
  prompt: ({ inquirer, args }) => {
    const questions = [
      {
        type: "input",
        name: "component_name",
        message: "What is the name of component?",
      },
    ];
    return inquirer.prompt(questions).then(({ component_name }) => {
      const absCwd = process.env.NODENV_DIR || process.env.INIT_CWD;
      const cwd = absCwd.replace(`${process.cwd()}/`, "");
      const output_path = `${cwd}/${component_name}`;
      const component_path = `${cwd.replace(
        "src/components/",
        ""
      )}/${component_name}`;
      const dir = output_path.split("/");
      const category = dir[dir.length - 2];
      return {
        output_path,
        component_name,
        component_path,
        category,
      };
    });
  },
};
