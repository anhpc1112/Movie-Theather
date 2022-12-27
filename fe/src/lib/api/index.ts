export type HttpStatus = number;

export type BackendApiErr = {
  result: string;
  errorMessages?: string[];
  redirectUrl?: string;
  validatetionErrors?: {
    title: string;
    errors: {
      name: string;
      messages: string[];
    }[];
  };
};

export type Err = {
  status: HttpStatus;
} & BackendApiErr;

export type ErrResponse = {
  data: null;
  err: Err;
  status: HttpStatus;
};

export type DataResponse<T> = {
  data: T;
  err: null;
  status: HttpStatus;
};

export type HttpResponse<T> = DataResponse<T> | ErrResponse;
