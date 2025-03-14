import { useNavigate } from "react-router-dom";
import { useTranslation } from "react-i18next";
import styles from "./ErrorPage.module.scss";

import DefaultButton from "../../atoms/button/DefaultButton";
import { Page_Url } from "../../../router/Page_Url";
import ErrorLemon from "../../../assets/errorPage/lemonZombie.gif";

function ErrorPage() {
  const navigate = useNavigate();
  const { t } = useTranslation();
  return (
    <div className={styles.errorContainer}>
      <img src={ErrorLemon} alt="에러페이지에서 헤매는 레몬 좀비" />
      {t("error")}
      <div className={styles.buttonBox}>
        <DefaultButton onClick={() => navigate(Page_Url.Main)}>
          {t("button.goToMain")}
        </DefaultButton>
        <DefaultButton onClick={() => navigate(-1)}>
          {t("button.back")}
        </DefaultButton>
      </div>
    </div>
  );
}

export default ErrorPage;
