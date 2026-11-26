export interface AccountRequest {
    name: string | null;
    initialBalance: number | null;
    type: string | null;

}

export interface AccountResponse extends AccountRequest {
    id: number;
}
