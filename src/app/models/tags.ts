export interface TagsRequest {
  name: string | null;
}

export interface TagsResponse extends TagsRequest {
  id: number;
}
